class IniciosController < ApplicationController
  def new
    @title = "Chat Web"
  end

  def create
    if params[:nickname].present?
      session[:nickname] = params[:nickname]
      redirect_to pages_path
    else
      redirect_to root_path, :notice => "Debes ingresar un nombre de usuario"
    end
  end

  def destroy
    session.delete(:nickname)
    redirect_to root_path, :notice => "Nos vemos luego!"
  end
end