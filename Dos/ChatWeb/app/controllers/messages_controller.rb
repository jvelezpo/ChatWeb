class MessagesController < ApplicationController
  before_filter :nombre_usuario?
  
  def index
    @messages = Mensaje.limit(20).reverse
  end
  
  def create
    @message = Mensaje.new(params[:mensaje])
    @message.de = usuario_actual
    @message.save
    respond_to do |format|
      format.html { redirect_to messages_path }
      format.js { @messages = Mensaje.limit(20).reverse }
    end
  end
end
