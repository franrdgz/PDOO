#encoding:utf-8

require_relative 'Player'
require_relative 'monster'
require_relative 'Labyrinth'
require_relative 'game_state'
require_relative 'dice'

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
      @labyrinth = Labyrinth.new(5, 5, 4, 4)

      configure_labyrinth
    end

    def finished
      @labyrinth.have_a_winner
    end

    def get_game_state
      players_str = @players.map(&:to_s).join(", ")
      monsters_str = @monsters.map(&:to_s).join(", ")
      GameState.new(@labyrinth.to_s, players_str, monsters_str, @current_player_index, finished, @log)
    end

    def configure_labyrinth
      # Método sencillo para configurar el laberinto añadiendo obstáculos y monstruos
      m = Monster.new("Monster 1", Dice.random_intelligence, Dice.random_strength)
      @monsters << m
      @labyrinth.add_monster(2, 2, m)
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
    end

    def actual_direction(preferred_direction)
    end

    def combat(monster)
    end

    def manage_reward(winner)
    end

    def manage_resurrection
    end
  end
end