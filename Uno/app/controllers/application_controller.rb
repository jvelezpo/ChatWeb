class ApplicationController < ActionController::Base
  protect_from_forgery

  helper_method :logged_in?, :current_nickname, :users, :get_online_users, :delete_online_user



  def logged_in?
    current_nickname.present?
  end

  def current_nickname
    session[:nickname]
  end

  def require_nickname
    redirect_to root_path, :notice => "debes identificarte!" unless logged_in?
  end

  def users(name)
    user = Online.new
    user.name = name
    user.save
  end

  def get_online_users
    var = []
    Online.all.each do |user|
      var.push(user.name)
    end
    var
  end

  def delete_online_user
    var = Online.find_by_name current_nickname
    var.destroy
  end
end
