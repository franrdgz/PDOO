#encoding:utf-8

require_relative 'dice'
require_relative 'shield'

module Irrgarten
   class TestP1
      def self.main 
         puts "===PRUEBAS DE LA CALSE DICE (100 EJECUCIONES) ==="

         100.times do |i|
            puts "\n--- Iteración #{i + 1} ---"
            puts "Posición aleatoria (max 10): #{Dice.random_pos(10)}"
            puts "Jugador inicial (3 jugadores): #{Dice.who_starts(3)}"
            puts "Inteligencia aleatoria: #{Dice.random_intelligence}"
            puts "Fuerza aleatoria: #{Dice.random_strength}"
            puts "Resucitar jugador?: #{Dice.resurrect_player}"
            puts "Recompensa armas: #{Dice.weapons_reward}"
            puts "Recompensa escudos: #{Dice.shields_reward}"
            puts "Recompensa salud: #{Dice.health_reward}"
            puts "Potencia arma: #{Dice.weapon_power}"
            puts "Potencia escudo: #{Dice.shield_power}"
            puts "Usos restantes: #{Dice.uses_left}"
            puts "Intensidad (competencia 10.0): #{Dice.intensity(10.0)}"
            puts "Descartar elemento con 2 usos: #{Dice.discard_element(2)}"
         end
      end
   end
end

#Ejecutar las pruebas
Irrgarten::TestP1.main