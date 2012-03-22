class PagesController < ApplicationController

  before_filter :require_nickname


  def index
    @title = "Chat Web"
  end


end