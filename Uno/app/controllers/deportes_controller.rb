class DeportesController < ApplicationController
  def index
    @title = "Deporte"
    @deportes = Cocina.all
  end

  def create
    @deportes = Deporte.create!(params[:deporte])
  end
end
