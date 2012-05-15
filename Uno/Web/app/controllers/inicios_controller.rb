class IniciosController < ApplicationController

  def new
    @title = "Chat Web"
  end

  def create
    if params[:nickname].present?
      var = Online.find_by_name params[:nickname]
      if var.nil?
        session[:nickname] = params[:nickname].capitalize
        users(params[:nickname].capitalize)
        redirect_to pages_path
      else
        redirect_to root_path, :notice => "Este nombre de usuario ya esta en uso"
      end
    else
      redirect_to root_path, :notice => "Debes ingresar un nombre de usuario"
    end
  end

  def destroy
    delete_online_user
    session.delete(:nickname)
    redirect_to root_path, :notice => "Nos vemos luego!"
  end
end