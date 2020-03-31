import React, { useCallback, useState, useEffect } from 'react';
import Header from '../Header';
import Dieta from '../Dieta';
import { useParams, Link, NavLink } from "react-router-dom";
import './styles.css';


function DietaDetalle() {

	const [ dieta, setDieta] = useState();
	
	const { id } = useParams();
	
	const fetchDieta = useCallback(() => {
	    return fetch(`../../../dieta/${id}`)
	      .then(res => res.json())
	      .then(dieta => {
	        setDieta(dieta)
	        console.log(dieta);
	      });
	  	}, []);
    console.log(dieta);
    useEffect(() => {
	    fetchDieta(dieta);
	  }, []);	
	
    if (!dieta){
    	return null;
    }	
	return(
	  <div>
	  	  <Header/>
	  	  <div className="dieta-detalle-container container clearfix">
	  			<img className="dieta-detalle-imagen" src={dieta.url_imagen} alt={dieta.nombre}/>
				<div className="dieta-detalle-info">
					<h2 className="dieta-detalle-nombre"> {dieta.nombre} </h2>
					<div className="dieta-detalle-field">
						<b> Tipo: </b>{dieta.tipo}
					</div>
					<div className="dieta-detalle-field">
						<b> Descripción: </b>{dieta.descripcion}
					</div>

					<p>Puedes ver los productos de esta dieta en el siguiente enlace:</p>
					<NavLink to={`../../../producto/dieta/list/${dieta.id}`} className="dieta-detalle-productos link-button">
					Productos
					</NavLink>
				</div>
	  	  	</div>
	 </div>
	);

}

export default DietaDetalle