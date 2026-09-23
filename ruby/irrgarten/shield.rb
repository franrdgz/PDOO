#encoding:utf-8
module Irrgarten
  class Shield
    def initialize(protection, uses)
      @protection = protection
      @uses = uses
    end

    def protect
      if @uses > 0
        @uses -= 1
        return @protection
      else
        return 0.0
      end
    end

    def to_s
      "S[#{@protection}, #{@uses}]"
    end

    def discard
      Dice.discard_element(@uses)
    end
  end
end