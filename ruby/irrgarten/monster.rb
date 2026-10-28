#encoding:utf-8

require_relative 'dice'

module Irrgarten
  class Monster
    @@INITIAL_HEALTH = 5

    def initialize(name, intelligence, strength)
      @name = name
      @intelligence = intelligence.to_f
      @strength = strength.to_f
      @health = @@INITIAL_HEALTH
      @row = -1
      @col = -1
    end

    def dead
      @health <= 0
    end

    def attack
      Dice.intensity(@strength)
    end

    def set_pos(row, col)
      @row = row
      @col = col
    end

    def to_s
      "M[#{@name}, H:#{@health}, S:#{@strength}, I:#{@intelligence}, Pos:(#{@row},#{@col})]"
    end

    def got_wounded
      @health -= 1
    end

    def defend(received_attack)
      # Pendiente P3
    end
  end
end
