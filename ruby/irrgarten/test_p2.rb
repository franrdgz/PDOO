#encoding:utf-8

require_relative 'game'

module Irrgarten
  class TestP2
    def self.main
      game = Game.new(2)
      state = game.get_game_state
      
      puts "=== ESTADO INICIAL DEL JUEGO (RUBY) ==="
      puts "Laberinto:\n#{state.labyrinth}"
      puts "Jugadores: #{state.players}"
      puts "Monstruos: #{state.monsters}"
      puts "Jugador actual: #{state.current_player}"
      puts "¿Hay ganador?: #{state.winner}"
    end
  end
end

Irrgarten::TestP2.main