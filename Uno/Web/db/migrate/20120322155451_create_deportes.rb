class CreateDeportes < ActiveRecord::Migration
  def self.up
    create_table :deportes do |t|
      t.string :content

      t.timestamps
    end
  end

  def self.down
    drop_table :deportes
  end
end
