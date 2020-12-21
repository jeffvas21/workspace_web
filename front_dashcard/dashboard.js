function carregaDash(){
    var strUser = localStorage.getItem("dashcardUser");
    if (!strUser){
        window.location = "index.html";
    }

    // usuario está conectado... preciso consultar o relatórico consolidado no back end
    var strId = window.location.search;
    console.log(strId);

    var idAgente = strId.substr(4);
    console.log("ID recuperado = "+idAgente);

    fetch("http://localhost:8088/totaisconsolidados?id="+idAgente)
       .then(res => res.json())
       .then(lista => preencheDash(lista));
}

function preencheDash(lista){
    console.log(lista);
    var nomeAgente;
    var volume;


    for (i=0; i<lista.length; i++){
        var ag = lista[i];
        nomeAgente = ag.nomeAgente;
        volume = ag.volume;
        status = ag.status;
        nroOP  = ag.numeroOp;

        if (status == 0) {
            var sucessos = nroOP;
        } else if (status == 1) {
            var falhas = nroOP;
        } else if (status == 2) {
            var fraudes = nroOP;
        }
    }

    document.getElementById("nomeAgente").innerHTML   = "<h3>"+nomeAgente+"</h3>";
    document.getElementById("volumeAgente").innerHTML = "<h4>Volume : "+volume+"</h4>";
    document.getElementById("totalSucesso").innerHTML = "<h4>Sucesso: "+sucessos+"</h4>";
    document.getElementById("totalFalha").innerHTML   = "<h4>Falhas: "+falhas+"</h4>";
    document.getElementById("totalFraude").innerHTML  = "<h4>Fraudes: "+fraudes+"</h4>";


var ctx = document.getElementById('meuGrafico');
var myChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Sucesso', 'Falha', 'Fraude'],
        datasets: [{
            label: '# de operacoes',
            data: [sucessos, falhas, fraudes],
            animation: "true",
            backgroundColor: [
                'rgba(0,0,255,0.2)',
                'rgba(0,120,120,0.2)',
                'rgba(255,0,0,0.2)'
            ],
            borderColor: ['rgba(0,0,0)',
                          'rgba(0,0,0)', 
                          'rgba(0,0,0)'],
       }]
    },
    options : {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
});
}

