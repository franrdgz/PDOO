#encoding:utf-8

require_relative 'Player'
require_relative 'dice'

module Irrgarten
  class FuzzyPlayer < Player
    def initialize(other)
      copy(other)
    end

    def move(direction, valid_moves)
      preferred = super(direction, valid_moves)
      Dice.next_step(preferred, valid_moves, @intelligence)
    end

    def attack
      sum_weapons + Dice.intensity(@strength)
    end

    def defensive_energy
      sum_shields + Dice.intensity(@intelligence)
    end

    def to_s
      "Fuzzy " + super
    end
  end
end