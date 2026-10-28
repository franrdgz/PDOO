#encoding:utf-8

module Irrgarten
   class monster
      #Atributo de clase para posición inicial no válida/fuera del tablero
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

      #Método pendiente para la práctica 3
      def defend(recieved_attack)
         #Pendiente P3
      end
   end
end