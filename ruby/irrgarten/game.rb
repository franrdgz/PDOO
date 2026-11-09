#encoding:utf-8

require_relative 'Player'
require_relative 'monster'
require_relative 'Labyrinth'
require_relative 'game_state'
require_relative 'dice'
require_relative 'game_character'

module Irrgarten
  class Game
    @@MAX_ROUNDS = 10

    def initialize(nplayers)
      @players = Array.new
      nplayers.times do |i|
        @players << Player.new(i.to_s.chr, Dice.random_intelligence, Dice.random_strength)
      end

      @current_player_index = Dice.who_starts(nplayers)
      @current_player = @players[@current_player_index]

      @monsters = Array.new
      @log = ""

      # Creamos un laberinto de prueba (ej. 5x5 con salida en (4,4))
      @labyrinth = Labyrinth.new(10, 10, 9, 9)

      configure_labyrinth
      @labyrinth.spread_players(@players)
    end

    def finished
      @labyrinth.have_a_winner
    end

    def game_state
      players_str = @players.map(&:to_s).join(", ")
      monsters_str = @monsters.map(&:to_s).join(", ")
      GameState.new(@labyrinth.to_s, players_str, monsters_str, @current_player_index, finished, @log)
    end

    def configure_labyrinth
      @labyrinth.add_block(Orientation::VERTICAL, 1, 1, 3)
      @labyrinth.add_block(Orientation::HORIZONTAL, 4, 2, 4)
      
      # Monstruos
      m1 = Monster.new("Orc", 4.0, 3.0)
      @monsters << m1
      @labyrinth.add_monster(2, 2, m1)
      
      m2 = Monster.new("Goblin", 3.0, 2.0)
      @monsters << m2
      @labyrinth.add_monster(5, 5, m2)
    end

    def next_player
      @current_player_index = (@current_player_index + 1) % @players.size
      @current_player = @players[@current_player_index]
    end

    def log_player_won
      @log += "El jugador ha ganado el combate.\n"
    end

    def log_monster_won
      @log += "El monstruo ha ganado el combate.\n"
    end

    def log_resurrected
      @log += "El jugador ha resucitado.\n"
    end

    def log_player_skip_turn
      @log += "El jugador ha perdido el turno por estar muerto.\n"
    end

    def log_player_no_orders
      @log += "El jugador no ha seguido las instrucciones.\n"
    end

    def log_no_monster
      @log += "El jugador se ha movido a una celda vacia o no le ha sido posible moverse.\n"
    end

    def log_rounds(rounds, max)
      @log += "Se han producido #{rounds} rondas de #{max} rondas de combate.\n"
    end

    # Cabeceras de métodos vacías pendientes para P3
    def next_step(preferred_direction)
      @log = ""
      is_dead = @current_player.dead
      
      if !is_dead
        direction = actual_direction(preferred_direction)
        if direction != preferred_direction
          log_player_no_orders
        end
        
        monster = @labyrinth.put_player(direction, @current_player)
        if monster == nil
          log_no_monster
        else
          winner = combat(monster)
          manage_reward(winner)
        end
      else
        manage_resurrection
      end
      
      end_game = finished
      if !end_game
        next_player
      end
      
      end_game
    end

    def actual_direction(preferred_direction)
      current_row = @current_player.row
      current_col = @current_player.col
      valid_moves = @labyrinth.valid_moves(current_row, current_col)
      @current_player.move(preferred_direction, valid_moves)
    end

    def combat(monster)
      rounds = 0
      winner = GameCharacter::PLAYER
      player_attack = @current_player.attack
      lose = monster.defend(player_attack)
      
      while !lose && rounds < @@MAX_ROUNDS
        monster_attack = monster.attack
        winner = GameCharacter::MONSTER
        rounds += 1
        lose = @current_player.defend(monster_attack)
        
        if !lose
          player_attack = @current_player.attack
          winner = GameCharacter::PLAYER
          lose = monster.defend(player_attack)
        end
      end
      
      log_rounds(rounds, @@MAX_ROUNDS)
      winner
    end

    def manage_reward(winner)
      if winner == GameCharacter::PLAYER
        @current_player.received_reward
        log_player_won
      else
        log_monster_won
      end
    end

    def manage_resurrection
      resurrect = Dice.resurrect_player
      if resurrect
        @current_player.resurrect
        log_resurrected
      else
        log_player_skip_turn
      end
    end
  end
end