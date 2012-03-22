class ApplicationController < ActionController::Base
  protect_from_forgery

  helper_method :logged_in?, :current_nickname

  def logged_in?
    current_nickname.present?
  end

  def current_nickname
    session[:nickname]
  end

  def require_nickname
    redirect_to root_path unless logged_in?
  end

end
