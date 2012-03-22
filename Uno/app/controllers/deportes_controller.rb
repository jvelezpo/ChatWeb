class DeportesController < ApplicationController

  before_filter :require_nickname

  def index
    @deportes = Deporte.all
    @title = "Deporte"
  end

  def create
    @deportes = Deporte.create!(params[:deporte])
  end
end
