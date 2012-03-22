$(function() {
  var faye = new Faye.Client('http://localhost:9292/faye');
  faye.subscribe("/messages/new", function(data) {
    eval(data);
  });
});

$(function() {
    var faye = new Faye.Client('http://localhost:9292/faye');
    faye.subscribe("/cocinas/new", function(data) {
        eval(data);
    });
});