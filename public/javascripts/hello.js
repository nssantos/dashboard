if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
  setInterval(function(){
              $.ajax(jsRoutes.controllers.HomeController.metrics())
                  .done(function(data){
                      $('#free-disk').text(data.freeDiskSpace);
                      $('#total-disk').text(data.totalDiskSpace);
                      $('#free-mem').text(data.freeMemoryPercentage+" %");
                      $('#used-mem').text(data.usedMemoryPercentage+" %");
                      myChart.push([{time: parseInt(new Date().getTime()/1000), y: data.freeMemory}, {time: parseInt(new Date().getTime()/1000), y: data.usedMemory}]);
                  })
                  .fail( /*...*/ );
              }, 1000);

}

var myChart = $('#mem-chart').epoch({
    type: 'time.bar',
    axes: ['right', 'bottom', 'left'],
    data:[{
        label: "Free Memory",
        values: [{time: parseInt(new Date().getTime()/1000), y: 0}]},
        {
        label: "Used Memory",
        values: [{time: parseInt(new Date().getTime()/1000), y: 0}]}]
});

