import React, { useCallback, useState, useEffect } from 'react';

import './styles.css';
import Header from '../Header';
import { useHistory } from "react-router-dom";

import {Card} from 'primereact/card';

function Dashboard() {
	let history = useHistory();
	const [dashboardDatos, setDashboardDatos] = useState([]);

	const dashboard = useCallback(() => {
		return fetch('dashboard' , {headers: {
		'Content-Type' : 'application/json',
		'Accept' : 'application/json',
		'Authorization' : 'Bearer ' + localStorage.getItem('auth')},
		method:'GET'})
			.then(res => res.json())
			.then(response => {
				setDashboardDatos(response)
			});
		}, []);
		useEffect(() => {
			dashboard(dashboardDatos);
			}, []);

  return(
	<div>
		<Header/>
		<div className="container">

			<Card title="Dashboard" style={{margin: 20}} >
				<div>
					<p>Media de cestas por usuario: {dashboardDatos[0]}</p>
					<p>Número de usuarios totales: {dashboardDatos[1]}</p>
					<p>Media  de pedidos por cliente: {dashboardDatos[2]}</p>
					<p>Número de pedidos totales: {dashboardDatos[3]}</p>
					<p>Número de pedidos última semana: {dashboardDatos[4]}</p>
					<p>Número de usuarios que han realizado pedidos: {dashboardDatos[5]}</p>
					<p>Número de usuarios que han realizado pedidos entre el total: {dashboardDatos[6]}%</p>
					<p>Media de artículos por pedido: {dashboardDatos[7]}</p>
					<p>Mínimo de artículos por pedido: {dashboardDatos[8]}</p>
					<p>Máximo de artículos por pedido: {dashboardDatos[9]}</p>
					<p>Ratio usuario con dietas vs usuarios sin dietas: {dashboardDatos[10]}%</p>
					<p>Ratio usuario sin dietas vs usuarios con dietas: {dashboardDatos[11]}%</p>
					<p>Ratio usuario con 1 envío y sin dietas: {dashboardDatos[12]}%</p>
					<p>Ratio usuario con 1 envío y dietas: {dashboardDatos[13]}%</p>
					<p>Ratio usuario con 2 envíos y sin dietas: {dashboardDatos[14]}%</p>
					<p>Ratio usuario con 2 envíos y con dietas: {dashboardDatos[15]}%</p>
					<p>Ratio usuario con 3 envíos y sin dietas: {dashboardDatos[16]}%</p>
					<p>Ratio usuario con 3 envíos y con dietas: {dashboardDatos[17]}%</p>
					<p>Ratio usuario con 4 envíos y sin dietas: {dashboardDatos[18]}%</p>
					<p>Ratio usuario con 4 envíos y con dietas: {dashboardDatos[19]}%</p>
					<p>Suscripciones registradas en total: {dashboardDatos[20]}</p>
					<p>Ratio de usuarios suscritos: {dashboardDatos[21]}%</p>
					<p>Supermercado con más ventas: {dashboardDatos[22]}</p>
					<p>Hora/s de envío más frecuente/s: {dashboardDatos[23]}</p>
					<p>Día/s de la semana cuando se producen más envíos: {dashboardDatos[23]}</p>
				</div>
			</Card>
		</div>
	</div>
 );
}
export default Dashboard;
