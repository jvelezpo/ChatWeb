class CocinasController < ApplicationController
  def index
    @cocinas = Cocina.all
  end

  def create
    @cocinas = Cocina.create!(params[:cocina])
  end
end
