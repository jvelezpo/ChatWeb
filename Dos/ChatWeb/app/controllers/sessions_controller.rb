class SessionsController < ApplicationController
  def new
  end
  
  def create
    if params[:usuario].present?
      session[:usuario] = params[:usuario]
      redirect_to messages_path
    else
      render "new"
    end
  end
  
  def destroy
    session.delete(:usuario)
    redirect_to new_session_path, :notice => "esperamos verte pronto"
  end
end
