#encoding:utf-8

require_relative 'Player'
require_relative 'Labyrinth'
require_relative 'weapon'
require_relative 'shield'
require_relative 'enumerados'
require_relative 'dice'

module Irrgarten
  class TestP3
    def self.main
      puts "=== PRUEBAS SOCIO B (P3 RUBY) ==="

      # 1. Crear una instancia de Player
      player = Player.new('0', 5.0, 5.0)

      puts "Añadiendo armas..."
      player.receive_weapon(Weapon.new(2.0, 0)) 
      player.receive_weapon(Weapon.new(3.0, 2))

      puts "Estado Player: #{player.to_s}"

      # 2. Probar Labyrinth
      lab = Labyrinth.new(6, 6, 5, 5)
      lab.add_block(Orientation::VERTICAL, 0, 1, 3)
      puts "\nLaberinto con bloque vertical:"
      puts lab.to_s

      # 3. Probar valid_moves
      moves = lab.valid_moves(0, 0)
      puts "\nMovimientos válidos desde (0,0): #{moves}"
    end
  end
end

Irrgarten::TestP3.main