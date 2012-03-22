class CreateCocinas < ActiveRecord::Migration
  def self.up
    create_table :cocinas do |t|
      t.string :content

      t.timestamps
    end
  end

  def self.down
    drop_table :cocinas
  end
end
