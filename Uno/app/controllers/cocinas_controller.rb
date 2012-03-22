class CocinasController < ApplicationController

  before_filter :require_nickname

  def index
    @cocinas = Cocina.all
    @title = "Cocina"
  end

  def create
    @cocinas = Cocina.create!(params[:cocina])
  end
end
