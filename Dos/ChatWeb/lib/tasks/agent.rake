namespace :agent do
  task :start => :environment do
    config = YAML.load_file(Rails.root.join("config/app_config.yml"))["chat_server"]
    c = ChatClient.new(config["host"],  config["port"].to_i, "Web-agent")
    c.run
  end
end

