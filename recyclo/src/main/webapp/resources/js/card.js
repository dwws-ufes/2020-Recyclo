function Card({title,arr,type='card-default',tools=false,toolsType='bg-info',extra=''}){
    let text = `<div class="card ${type}" ${extra}>
	                <div class="card-header" style="margin-bottom: 0 !important;>
		                <h3 class="card-title" id="title">${title}</h3>`;
    if (tools) text+= `<div class="card-tools">
                            <button type="button" class="btn ${toolsType} btn-sm" data-card-widget="collapse">
                                <i class="fas fa-minus"></i>
                            </button>
                            <button type="button" class="btn ${toolsType} btn-sm" data-card-widget="remove">
                                <i class="fas fa-times"></i>
                            </button>
                          </div>`;
    text += `</div><div class="card-body">
                        <div style="display: content" id="content">`;
    for (let elem of arr){
        text += elem;
    }
    return text + `</div></div></div>`;
}

function Paciente({nome='',idade='',data='',atendimento='', equipe='', realizacao='', atendimentoLabel='Atendimento PS: '}){
  let text =  `<div class="row">
                  <div class="col-12 col-md-6 text-left">
                      <p><b>Nome: </b>${nome}<p>
                      <p><b>Idade: </b>${idade}<p>
                  </div>
                  <div class="col-12 col-md-6 text-left">
                      <p><b>${atendimentoLabel}</b>${atendimento}<p>
                      <p><b>Data do Atendimento: </b>${data}<p>
                  </div>
                  ${equipe != '' && realizacao != '' ? `
                  <div class="col-12 text-left">
                    <div class="row">
                      <div class="col-12 col-md-6 text-left">
                        <p><b>Equipe: </b>${equipe}<p>
                      </div>
                      <div class="col-12 col-md-6 text-left">
                        <p><b>Data de Realização: </b>${realizacao}<p>
                      </div>
                    </div>
                  </div>` : ''}
              </div>`

  return text;
}

function SmallBox({ info='', info_label='', footer='', type='info', icon='ion ion-stats-bars', link='#'}) {
    let text = `<div class="small-box bg-${type}">
                    <div class="inner">
                        <h3>${info}</h3>
                        <p>${info_label}</p>
                    </div>
                    <div class="icon">
                        <i class="${icon}"></i> 
                    </div>
                    <a href='${link}' class="small-box-footer">${footer} <i class="fas fa-arrow-circle-right"></i></a>
                </div>`;
    return text;
}

function Header({title, optional=''}){
    let text = `<div class="row align-items-center py-4">
            <div class="col-12 col-md-6">
              <h6 class="h2 text-white d-inline-block mb-0">${title}</h6>
            </div>
            <div class="col-12 col-md-6">
              ${optional}
            </div>
          </div>`
    return text;
}

function Header4Cards({title1, title2, title3, title4}){
return `<div class="row">
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">${title1}</h5>
                      <span class="h2 font-weight-bold mb-0">0</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-red text-white rounded-circle shadow">
                        <i class="ni ni-active-40"></i>
                      </div>
                    </div>
                  </div>
                  <p class="mt-3 mb-0 text-sm">
                    <span class="text-success mr-2"><i class="fa fa-arrow-up"></i> 0%</span>
                    <span class="text-nowrap">desde o último mês</span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">${title2}</h5>
                      <span class="h2 font-weight-bold mb-0">0</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-orange text-white rounded-circle shadow">
                        <i class="ni ni-chart-pie-35"></i>
                      </div>
                    </div>
                  </div>
                  <p class="mt-3 mb-0 text-sm">
                    <span class="text-success mr-2"><i class="fa fa-arrow-up"></i> 0%</span>
                    <span class="text-nowrap">desde o último mês</span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">${title3}</h5>
                      <span class="h2 font-weight-bold mb-0">0</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-green text-white rounded-circle shadow">
                        <i class="ni ni-money-coins"></i>
                      </div>
                    </div>
                  </div>
                  <p class="mt-3 mb-0 text-sm">
                    <span class="text-success mr-2"><i class="fa fa-arrow-up"></i> 0%</span>
                    <span class="text-nowrap">desde o último mês</span>
                  </p>
                </div>
              </div>
            </div>
            <div class="col-xl-3 col-md-6">
              <div class="card card-stats">
                <!-- Card body -->
                <div class="card-body">
                  <div class="row">
                    <div class="col">
                      <h5 class="card-title text-uppercase text-muted mb-0">${title4}</h5>
                      <span class="h2 font-weight-bold mb-0">0</span>
                    </div>
                    <div class="col-auto">
                      <div class="icon icon-shape bg-gradient-info text-white rounded-circle shadow">
                        <i class="ni ni-chart-bar-32"></i>
                      </div>
                    </div>
                  </div>
                  <p class="mt-3 mb-0 text-sm">
                    <span class="text-success mr-2"><i class="fa fa-arrow-up"></i> 0%</span>
                    <span class="text-nowrap">desde o último mês</span>
                  </p>
                </div>
              </div>
            </div>
          </div>`
}

function MiniCard({id, title, value, tax, since, bgcolor = 'bg-gradient-red', up = true, link = null, icon = 'ni ni-active-40', extraClass='enabled'}){
  // ideal:  col-xl-3 col-md-6
  return `<a class="card card-stats ${extraClass}" ${(link != null) ? `href='${link}' style="cursor: pointer"` : ''}>
            <!-- Card body -->
            <div class="card-body ${extraClass}">
              <div class="row">
                <div class="col">
                  <h5 class="card-title text-uppercase text-muted mb-0">${title}</h5>
                  <span style="word-break: keep-all;" class="h3 font-weight-bold mb-0" id="${id}-valor">${value}</span>
                </div>
                <div class="col-auto">
                  <div class="icon icon-shape ${bgcolor} text-white rounded-circle shadow">
                    <i class="${icon}"></i>
                  </div>
                </div>
              </div>
              <p class="mt-3 mb-0 text-sm">
                <span class="text-success mr-2"> <i id="${id}-taxa" class="fa fa-arrow-alt-circle-right"> ${tax}</i></span>
                <span class="text-nowrap" style="color: #525f7f">${since}</span>
              </p>
            </div>
          </a>`
  }

export { Card, SmallBox, Header, Header4Cards, Paciente, MiniCard };