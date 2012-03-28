class DeportesController < ApplicationController

  before_filter :require_nickname

  def index
    @deportes = Deporte.all
    @title = "Deporte"
  end

  def create
    var = params[:deporte]
    
    @deportes = Deporte.create!(:content => "#{session[:nickname]} dice: #{var["content"]}")
  end
end
