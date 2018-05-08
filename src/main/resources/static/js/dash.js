$(document).ready(function() {
	
	getSwapiData('planets'  )
	getSwapiData('species'  )
	getSwapiData('people'   )
	getSwapiData('starships')
	getSwapiData('vehicles' )
		
})

var chartData = {
	  labels: [],
	  datasets: [
		  {
			  data: [],
			  lineTension: 0,
			  backgroundColor: '#007bff',
			  borderColor: '#000000',
			  borderWidth: 1,
			  pointBackgroundColor: '#007bff'
	      }
	  ]
}

var chartOptions = {
		scales: {
			yAxes: [{
				ticks: {
					beginAtZero: true
				}
			}]
		},
		legend: {
			display: false,
		}
}

var ctx = document.getElementById("myChart")

var myChart = new Chart(ctx, {
	type: "bar",
	data: chartData,
	options: chartOptions
})



// from www.chartsjs.org/docs
function addChartDatapoint(chart, dataobj) {
	chart.data.labels.push(dataobj.thing)
	chart.data.datasets.forEach((dataset) => {
		dataset.data.push(dataobj.count)
	})
	chart.update()
}

// from www.chartsjs.org/docs
function delChartDatapoint(chart) {
	chart.data.labels.pop();
	chart.data.datasets.forEach((dataset) => {
		dataset.data.pop()
	})
	chart.upate()
}

//this is kinda clumsy
function getSwapiData(thing) {
	
	let url = 'https://swapi.co/api/' + thing
	$.getJSON(url)
	 .done(function(data) {
		 console.log(data)
		 let retObj={}
		 retObj.thing = thing
		 retObj.count = data.count
		 addChartDatapoint(myChart, retObj)
		 return retObj
	 })
	 .fail(function(data) {
		 console.log(data)
		 return 0
	 })
	 
}

