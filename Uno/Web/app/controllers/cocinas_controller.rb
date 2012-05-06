class CocinasController < ApplicationController

  before_filter :require_nickname

  def index
    @cocinas = Cocina.all
    @title = "Cocina"
  end

  def create
    var = params[:cocina]
    @cocinas = Cocina.create!(:content => "#{session[:nickname]} dice: #{var["content"]}")
  end

 end
