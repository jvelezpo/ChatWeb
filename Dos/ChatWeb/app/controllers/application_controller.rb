class ApplicationController < ActionController::Base
  protect_from_forgery
  
  helper_method :conectado?, :usuario_actual, :titulo
  
  def conectado?
    usuario_actual.present?
  end
  
  def usuario_actual
    session[:usuario]
  end
  
  def nombre_usuario?
    redirect_to root_path unless conectado?
  end

 end
