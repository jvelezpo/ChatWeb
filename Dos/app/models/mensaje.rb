class Mensaje < ActiveRecord::Base
  default_scope order("created_at desc")
  validates_presence_of :de, :texto
end
