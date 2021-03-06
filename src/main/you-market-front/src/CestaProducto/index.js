import React from "react";
import { Link } from "react-router-dom";
import "./styles.css";

interface Props {
  id: number;
  producto: string;
  cesta: string;
}

function CestaProducto({ id, producto, cesta }: Props) {
  return (
    <div className="cesta-producto-container">
      <Link to={`../../../../show/producto/${producto.id}`}>
        <img
          className="cesta-producto-imagen"
          src={producto.urlImagen}
          alt="Imagen"
        />

        <div className="cesta-producto-info">
          <p className="cesta-producto-precio">
            {producto.precio.toFixed(2)} {producto.unidad}
          </p>
          <p className="cesta-producto-nombre">{producto.nombre}</p>
          <p className="cesta-producto-supermercado">
            {producto.supermercado.nombre}
          </p>
        </div>
      </Link>
    </div>
  );
}

export default CestaProducto;
