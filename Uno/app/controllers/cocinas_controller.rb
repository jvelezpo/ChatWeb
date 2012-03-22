class CocinasController < ApplicationController
  def index
    @title = "Cocina"
    @cocinas = Cocina.all
  end

  def create
    @cocinas = Cocina.create!(params[:cocina])
  end
end
