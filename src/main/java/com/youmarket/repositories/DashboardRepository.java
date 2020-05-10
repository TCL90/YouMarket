package com.youmarket.repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.youmarket.domain.Usuario;

@Repository
public interface DashboardRepository extends JpaRepository<Usuario, Integer>{

	@Query("select avg(1.0*(select count(c) from Cesta c where c not in (select p from Pedido p) and c.usuario.id = u.id group by c.usuario)) from Usuario u")
	public Double avgCestasPerClient();

	@Query("select count(u) from Usuario u")
	public Integer numUsuarios();
	
	@Query("select avg(1.0*(select count(f) from Factura f where f.usuario.id = u.id group by f.usuario)) from Usuario u")
	public Double avgPedidosPerClient();
	
	@Query("select count(f) from Factura f where f.pedido is not null")
	public Integer numPedidosTotales();
	
	@Query("select count(f) from Factura f where f.pedido is not null and f.fechaFactura between ?1 AND ?2")
	public Integer numPedidosUltimaSemana(Date start, Date end);
	
	@Query("select count(u) from Usuario u where u.id in (select p.usuario.id from Pedido p)")
	public Integer numUsuariosConPedidos();
	
	@Query("select 1.0 * count(u) / (select count(u1) from Usuario u1) from Usuario u where u.id in (select p.usuario.id from Pedido p)")
	public Double numUsuariosConPedidosVsTotal();

	@Query("select avg(1.0*(select sum(cp.cantidad) from CestaProducto cp where cp.cesta.id = p.id group by cp.cesta.id)) from Pedido p")
	public Double avgArticulosPerPedido();
	
	@Query("select max(select sum(cp.cantidad) from CestaProducto cp where cp.cesta.id = p.id group by cp.cesta.id) from Pedido p")
	public Integer maxArticulosPerPedido();
	
	@Query("select min(select sum(cp.cantidad) from CestaProducto cp where cp.cesta.id = p.id group by cp.cesta.id) from Pedido p")
	public Integer minArticulosPerPedido();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id != 2 and u.suscripcion.id != 4 and u.suscripcion.id != 6 and u.suscripcion.id != 8")
	public Double ratioUsuariosConNoDietvsDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 2 or u.suscripcion.id = 4 or u.suscripcion.id = 6 or u.suscripcion.id = 8")
	public Double ratioUsuariosConDietvsNoDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 1")
	public Double ratioUsuarios1EnvioSinDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 2")
	public Double ratioUsuarios1EnvioConDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 3")
	public Double ratioUsuarios2EnvioSinDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 4")
	public Double ratioUsuarios2EnvioConDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 5")
	public Double ratioUsuarios3EnvioSinDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 6")
	public Double ratioUsuarios3EnvioConDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 7")
	public Double ratioUsuarios4EnvioSinDiet();
	
	@Query("select 100.0 * count(u)/(select count(u1) from Usuario u1) from Usuario u where u.suscripcion.id = 8")
	public Double ratioUsuarios4EnvioConDiet();
	
	@Query("select count(f) from Factura f where f.suscripcion.id is not null")
	public Integer suscripcionesCobradas();
	
	@Query("select 100.0 * count(u1)/(select count(u) from Usuario u) from Usuario u1 where u1.pedidosRestantes >0")
	public Integer usuariosSuscritosVsNo();
	
	@Query("select p.supermercado.nombre from CestaProducto cp join cp.producto p group by p.supermercado order by count(p) desc")
	public Collection<String> superMasVentas();
	
	@Query("select p.horaEnvioIni from Pedido p group by p.horaEnvioIni order by count(p.horaEnvioIni) desc")
	public Collection<Integer> horaEnvioIniFrec();
	
	@Query("select DAYNAME(p.fechaEnvio) as WeekDay FROM Pedido p GROUP BY DAYNAME(p.fechaEnvio) ORDER BY COUNT(p.fechaEnvio) DESC")
	public Collection<String> diaSemanaSeCompraMas();

}
