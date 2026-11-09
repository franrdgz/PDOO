require_relative 'game'
# Ajusta estas rutas si tus carpetas se llaman diferente (ej. 'UI/textUI')
require_relative 'textUI'
require_relative 'controller'

module Irrgarten
  puts "=== INICIANDO PARTIDA IRRGARTEN (RUBY) ==="
  
  num_players = 2
  game = Game.new(num_players)
  
  view = UI::TextUI.new
  controller = Control::Controller.new(game, view)
  
  controller.play
end