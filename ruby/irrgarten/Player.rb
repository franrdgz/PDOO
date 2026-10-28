module Irrgarten
  class Player
    @@MAX_WEAPONS = 2
    @@MAX_SHIELDS = 3
    @@INITIAL_HEALTH = 10
    @@HITS2LOSE = 3

    def initialize(number, intelligence, strength)
      @name = "Player ##{number}"
      @number = number
      @intelligence = intelligence
      @strength = strength
      @health = @@INITIAL_HEALTH
      @row = -1
      @col = -1
      @consecutive_hits = 0
      @weapons = []
      @shields = []
    end

    def resurrect
      @weapons.clear
      @shields.clear
      @health = @@INITIAL_HEALTH
      @consecutive_hits = 0
    end

    def set_pos(row, col)
      @row = row
      @col = col
    end

    def dead
      @health <= 0
    end

    def attack
      @strength + sum_weapons
    end

    def defend(received_attack)
      manage_hit(received_attack)
    end

    def to_s
      "Player[Name: #{@name}, Health: #{@health}, Pos: (#{@row},#{@col}), Weapons: #{@weapons.size}, Shields: #{@shields.size}]"
    end

    def new_weapon
      Weapon.new(Dice.weapon_power, Dice.uses_left)
    end

    def new_shield
      Shield.new(Dice.shield_power, Dice.uses_left)
    end

    def defensive_energy
      @intelligence + sum_shields
    end

    def reset_hits
      @consecutive_hits = 0
    end

    def got_wounded
      @health -= 1
    end

    def inc_consecutive_hits
      @consecutive_hits += 1
    end

    def sum_weapons
      @weapons.sum { |w| w.attack }
    end

    def sum_shields
      @shields.sum { |s| s.protect }
    end

    # Cabeceras
    def move(direction, valid_moves)
      raise NotImplementedError
    end

    def receive_reward
      raise NotImplementedError
    end

    def receive_weapon(w)
      raise NotImplementedError
    end

    def receive_shield(s)
      raise NotImplementedError
    end

    def manage_hit(received_attack)
      raise NotImplementedError
    end
  end
end