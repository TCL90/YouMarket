package com.youmarket.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;
import com.youmarket.configuration.security.UserPrincipal;
import com.youmarket.domain.Role;
import com.youmarket.domain.Usuario;
import com.youmarket.domain.enums.RoleName;
import com.youmarket.repositories.DashboardRepository;

@Service
public class DashboardService {

	@Autowired
	private DashboardRepository dashboardRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Boolean chechAdmin(UserPrincipal currentUser) {
		Usuario currUser = null;
		
		Optional<Usuario> user1 = this.usuarioService.findById(currentUser.getId());
		if(user1.isPresent()) {
			currUser = user1.get();
		}
		
		Set<Role> roleSet = currUser.getRoles();
		boolean isAdmin = roleSet.contains(new Role((long) 4, RoleName.ADMIN));
		return isAdmin;
	}
	
	public Double avgCestasPerClient(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.avgCestasPerClient();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);

		return bd.doubleValue();
		
	}
	
	public Integer numUsuarios(UserPrincipal currentUser) {
		Integer res=null;
		res=this.dashboardRepository.numUsuarios();
		
		return res;
	}
	
	public Double avgPedidosPerClient(UserPrincipal currentUser) {
		Double res=null;

		res=this.dashboardRepository.avgPedidosPerClient();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Integer numPedidosTotales(UserPrincipal currentUser) {
		Integer res=null;
		
		res=this.dashboardRepository.numPedidosTotales();
		
		return res;
	}
	
	public Integer numPedidosUltimaSemana(UserPrincipal currentUser) {
		Integer res = null;
		
	    Date date = new Date();
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
	    c.add(Calendar.DATE, -i - 7);
	    Date start = c.getTime();
	    c.add(Calendar.DATE, 6);
	    Date end = c.getTime();
		
		res=this.dashboardRepository.numPedidosUltimaSemana(start, end);
		
		return res;	
	}
	
	public Integer numUsuariosConPedidos(UserPrincipal currentUser) {
		Integer res = null;

		res=this.dashboardRepository.numUsuariosConPedidos();
		
		return res;		
	}
	
	public Double numUsuariosConPedidosVsTotal(UserPrincipal currentUser) {
		Double res = null;
		res=this.dashboardRepository.numUsuariosConPedidosVsTotal();
		
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();	
		
	}
	
	public Double avgArticulosPerPedido(UserPrincipal currentUser) {
		Double res = null;
	
		res=this.dashboardRepository.avgArticulosPerPedido();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();	
	}
	
	public Integer maxArticulosPerPedido(UserPrincipal currentUser) {
		Integer res = null;
	
		res=this.dashboardRepository.maxArticulosPerPedido();
		System.out.println(res);
		return res;	
	}
	
	public Integer minArticulosPerPedido(UserPrincipal currentUser) {
		Integer res = null;
		
		res=this.dashboardRepository.minArticulosPerPedido();
		
		return res;	
	}
	
	public Double ratioUsuariosConDietvsNoDiet(UserPrincipal currentUser) {
		Double res = null;

		res=this.dashboardRepository.ratioUsuariosConDietvsNoDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuariosSinDietvsConDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuariosConNoDietvsDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios1EnvioSinDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios1EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios1EnvioConDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios1EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios2EnvioSinDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios2EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios2EnvioConDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios2EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios3EnvioSinDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios3EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios3EnvioConDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios3EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios4EnvioSinDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios4EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios4EnvioConDiet(UserPrincipal currentUser) {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios4EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Integer suscripcionesCobradas(UserPrincipal currentUser) {
		Integer res = null;
		
		res=this.dashboardRepository.suscripcionesCobradas();
		
		return res;
	}
	
	public Integer usuariosSuscritosVsNo(UserPrincipal currentUser) {
		Integer res = null;
		
		res=this.dashboardRepository.usuariosSuscritosVsNo();
		
		return res;
	}
	
	public String superMasVentas(UserPrincipal currentUser) {
		List<String> res = null;
		
		res=new ArrayList<>(this.dashboardRepository.superMasVentas());
		
		return res.get(0);
	}
	
	public String horaEnvioIniFrec(UserPrincipal currentUser) {
		List<Integer> res = null;
		String result = null;
		
		res = new ArrayList<>(this.dashboardRepository.horaEnvioIniFrec());
		if(res.size()>=3) {
			result = String.valueOf(res.get(0)) + ":00, " + String.valueOf(res.get(1)) + ":00, " + String.valueOf(res.get(2)) + ":00";
			
		}else if(res.size()==2) {
			result = String.valueOf(res.get(0)) + ":00, " + String.valueOf(res.get(1)) + ":00";
		}else if(res.size()==1) {
			result = String.valueOf(res.get(0)) + ":00";
		}else {
			result = "No hay pedidos en la web aún";
		}
		return result;
		
	}
	
	public String diaSemanaSeCompraMas(UserPrincipal currentUser) {
		List<String> res = null;
		String result = null;
		
		res = new ArrayList<>(this.dashboardRepository.diaSemanaSeCompraMas());
		if(res.size()>=3) {
			result = String.valueOf(res.get(0)) + ", " + String.valueOf(res.get(1)) + ", " + String.valueOf(res.get(2));
			
		}else if(res.size()==2) {
			result = String.valueOf(res.get(0)) + ", " + String.valueOf(res.get(1));
		}else if(res.size()==1) {
			result = String.valueOf(res.get(0));
		}else {
			result = "No hay pedidos en la web aún";
		}
		return result;
		
	}
	
}
