module ApplicationHelper
  def broadcast(channel, &block)
    message = {:channel => channel, :data => capture(&block), :ext => {:auth_token => FAYE_TOKEN}}
    uri = URI.parse("http://localhost:9292/faye")
    Net::HTTP.post_form(uri, :message => message.to_json)
  end

  def title
    base_title = "Chat"
    if @title.nil?
      base_title
    else
      "#{base_title} | #{@title}"
    end
  end
end
