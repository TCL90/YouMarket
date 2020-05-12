package com.youmarket.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youmarket.configuration.security.CurrentUser;
import com.youmarket.configuration.security.UserPrincipal;
import com.youmarket.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
    public ResponseEntity<Object> dashboard(@CurrentUser UserPrincipal currentUser) {
		List<Object> dashboard = new ArrayList<>();
		if(this.dashboardService.checkAdmin(currentUser)) {

		dashboard.add(this.dashboardService.avgCestasPerClient());
		dashboard.add(this.dashboardService.numUsuarios());
		dashboard.add(this.dashboardService.avgPedidosPerClient());
		dashboard.add(this.dashboardService.numPedidosTotales());
		dashboard.add(this.dashboardService.numPedidosUltimaSemana());
		dashboard.add(this.dashboardService.numUsuariosConPedidos());
		dashboard.add(this.dashboardService.numUsuariosConPedidosVsTotal());
		dashboard.add(this.dashboardService.ratioUsuariosConDietvsNoDiet());
		dashboard.add(this.dashboardService.ratioUsuariosSinDietvsConDiet());
		dashboard.add(this.dashboardService.ratioUsuarios1EnvioSinDiet());
		dashboard.add(this.dashboardService.ratioUsuarios1EnvioConDiet());
		dashboard.add(this.dashboardService.ratioUsuarios2EnvioSinDiet());
		dashboard.add(this.dashboardService.ratioUsuarios2EnvioConDiet());
		dashboard.add(this.dashboardService.ratioUsuarios3EnvioSinDiet());
		dashboard.add(this.dashboardService.ratioUsuarios3EnvioConDiet());
		dashboard.add(this.dashboardService.ratioUsuarios4EnvioSinDiet());
		dashboard.add(this.dashboardService.ratioUsuarios4EnvioConDiet());
		dashboard.add(this.dashboardService.suscripcionesCobradas());
		dashboard.add(this.dashboardService.usuariosSuscritosVsNo());
		dashboard.add(this.dashboardService.superMasVentas());
		dashboard.add(this.dashboardService.horaEnvioIniFrec());
		dashboard.add(this.dashboardService.diaSemanaSeCompraMas());
		dashboard.add(this.dashboardService.diaSemanaSeEnviaMas());
		dashboard.add(this.dashboardService.avgGastoPerPedido());
		dashboard.add(this.dashboardService.numPedidosUltimoMes());
		dashboard.add(this.dashboardService.numSusUltimoMes());
		}else {
			dashboard = new ArrayList<>();
		}
		
		return ResponseEntity.ok(dashboard);
		
    }
}
