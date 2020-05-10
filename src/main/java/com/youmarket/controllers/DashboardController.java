package com.youmarket.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youmarket.configuration.security.CurrentUser;
import com.youmarket.configuration.security.UserPrincipal;
import com.youmarket.domain.Usuario;
import com.youmarket.services.CestaService;
import com.youmarket.services.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping
    public ResponseEntity<Object> dashboard(@CurrentUser UserPrincipal currentUser) {
		List<Object> dashboard = new ArrayList<>();
		

		dashboard.add(this.dashboardService.avgCestasPerClient(currentUser));
		dashboard.add(this.dashboardService.numUsuarios(currentUser));
		dashboard.add(this.dashboardService.avgPedidosPerClient(currentUser));
		dashboard.add(this.dashboardService.numPedidosTotales(currentUser));
		dashboard.add(this.dashboardService.numPedidosUltimaSemana(currentUser));
		dashboard.add(this.dashboardService.numUsuariosConPedidos(currentUser));
		dashboard.add(this.dashboardService.numUsuariosConPedidosVsTotal(currentUser));
		dashboard.add(this.dashboardService.avgArticulosPerPedido(currentUser));
		dashboard.add(this.dashboardService.minArticulosPerPedido(currentUser));
		dashboard.add(this.dashboardService.maxArticulosPerPedido(currentUser));
		dashboard.add(this.dashboardService.ratioUsuariosConDietvsNoDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuariosSinDietvsConDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios1EnvioSinDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios1EnvioConDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios2EnvioSinDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios2EnvioConDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios3EnvioSinDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios3EnvioConDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios4EnvioSinDiet(currentUser));
		dashboard.add(this.dashboardService.ratioUsuarios4EnvioConDiet(currentUser));
		dashboard.add(this.dashboardService.suscripcionesCobradas(currentUser));
		dashboard.add(this.dashboardService.usuariosSuscritosVsNo(currentUser));
		dashboard.add(this.dashboardService.superMasVentas(currentUser));
		dashboard.add(this.dashboardService.horaEnvioIniFrec(currentUser));
		dashboard.add(this.dashboardService.diaSemanaSeCompraMas(currentUser));
		
		return ResponseEntity.ok(dashboard);
		
    }
}
