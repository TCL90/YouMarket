package com.youmarket.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Boolean checkAdmin(UserPrincipal currentUser) {
		Usuario currUser = null;
		boolean isAdmin=false;
		
		Optional<Usuario> user1 = this.usuarioService.findById(currentUser.getId());
		if(user1.isPresent()) {
			currUser = user1.get();
		}
		
		Set<Role> roleSet = currUser.getRoles();
		isAdmin = roleSet.contains(new Role((long) 4, RoleName.ADMIN));
		return isAdmin;
	}
	
	public Double avgCestasPerClient() {
		Double res = null;
		BigDecimal bd;
		
		res=this.dashboardRepository.avgCestasPerClient();
		if(res!=null) {
			bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		} else {
			bd = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
		}
		return bd.doubleValue();
		
	}
	
	public Integer numUsuarios() {
		Integer res=null;
		res=this.dashboardRepository.numUsuarios();
		
		return res;
	}
	
	public Double avgPedidosPerClient() {
		Double res=null;

		res=this.dashboardRepository.avgPedidosPerClient();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Integer numPedidosTotales() {
		Integer res=null;
		
		res=this.dashboardRepository.numPedidosTotales();
		
		return res;
	}
	
	public Integer numPedidosUltimaSemana() {
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
	
	public Integer numUsuariosConPedidos() {
		Integer res = null;

		res=this.dashboardRepository.numUsuariosConPedidos();
		
		return res;		
	}
	
	public Double numUsuariosConPedidosVsTotal() {
		Double res = null;
		res=this.dashboardRepository.numUsuariosConPedidosVsTotal();
		
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();	
		
	}
	
	public Double ratioUsuariosConDietvsNoDiet() {
		Double res = null;

		res=this.dashboardRepository.ratioUsuariosConDietvsNoDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuariosSinDietvsConDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuariosConNoDietvsDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios1EnvioSinDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios1EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios1EnvioConDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios1EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios2EnvioSinDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios2EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios2EnvioConDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios2EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios3EnvioSinDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios3EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios3EnvioConDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios3EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios4EnvioSinDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios4EnvioSinDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Double ratioUsuarios4EnvioConDiet() {
		Double res = null;
		
		res=this.dashboardRepository.ratioUsuarios4EnvioConDiet();
		BigDecimal bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		
		return bd.doubleValue();
	}
	
	public Integer suscripcionesCobradas() {
		Integer res = null;
		
		res=this.dashboardRepository.suscripcionesCobradas();
		
		return res;
	}
	
	public Integer usuariosSuscritosVsNo() {
		Integer res = null;
		
		res=this.dashboardRepository.usuariosSuscritosVsNo();
		
		return res;
	}
	
	public String superMasVentas() {
		List<String> res = null;
		
		res=new ArrayList<>(this.dashboardRepository.superMasVentas());
		String result = "";
		if(res.size()==0) {
			result = "No hay supermercados que hayan vendido aún";
		} else {
			result = res.get(0);
		}
		return result;
	}
	
	public String horaEnvioIniFrec() {
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
	
	public String traducDia(String diaSemana){
		String result=null;
		switch(diaSemana) {
		  case "Monday":
		    result = "Lunes";
		    break;
		  case "Tuesday":
			  result = "Martes";
		    break;
		  case "Wednesday":
			  result = "Miércoles";
			    break;
		  case "Thursday":
			  result = "Jueves";
			    break;
		  case "Friday":
			  result = "Viernes";
			    break;
		  case "Saturday":
			  result = "Sábado";
			    break;
		  default:
			  result = "Domingo";
		}
		return result;
	}
	
	public String diaSemanaSeCompraMas() {
		List<String> res = null;
		String result = null;
		
		res = new ArrayList<>(this.dashboardRepository.diaSemanaSeCompraMas());

		if(res.size()>=3) {
			result = this.traducDia(String.valueOf(res.get(0))) + ", " + this.traducDia(String.valueOf(res.get(1))) + ", " + this.traducDia(String.valueOf(res.get(2)));
			
		}else if(res.size()==2) {
			result = this.traducDia(String.valueOf(res.get(0))) + ", " + this.traducDia(String.valueOf(res.get(1)));
		}else if(res.size()==1) {
			result = this.traducDia(String.valueOf(res.get(0)));
		}else {
			result = "No hay pedidos en la web aún";
		}
		return result;
		
	}
	
	public String diaSemanaSeEnviaMas() {
		List<String> res = null;
		String result = null;
		
		res = new ArrayList<>(this.dashboardRepository.diaSemanaSeEnviaMas());

		if(res.size()>=3) {
			result = this.traducDia(String.valueOf(res.get(0))) + ", " + this.traducDia(String.valueOf(res.get(1))) + ", " + this.traducDia(String.valueOf(res.get(2)));
			
		}else if(res.size()==2) {
			result = this.traducDia(String.valueOf(res.get(0))) + ", " + this.traducDia(String.valueOf(res.get(1)));
		}else if(res.size()==1) {
			result = this.traducDia(String.valueOf(res.get(0)));
		}else {
			result = "No hay pedidos en la web aún";
		}
		return result;
		
	}
	
	public Double avgGastoPerPedido() {
		Double res = null;
		BigDecimal bd;
		res=this.dashboardRepository.avgGastoPerPedido();
		
		if(res != null) {
			bd = new BigDecimal(res).setScale(2, RoundingMode.HALF_UP);
		}else {
			bd = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_UP);
		}
		
		return bd.doubleValue();
	}
	
	public Integer numPedidosUltimoMes() {
		Integer res = null;
		
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH,1);
	    Date start = c.getTime();
	    c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
	    Date end = c.getTime();
		
		res=this.dashboardRepository.numPedidosUltimoMes(start, end);
		
		return res;	
	}
	
	public Integer numSusUltimoMes() {
		Integer res = null;
		
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH,1);
	    Date start = c.getTime();
	    c.set(Calendar.MONTH, c.get(Calendar.MONTH)+1);
	    Date end = c.getTime();
		
		res=this.dashboardRepository.numSusUltimoMes(start, end);
		
		return res;	
	}
	
}
