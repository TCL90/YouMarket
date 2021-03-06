import React, { useCallback, useEffect, useState } from "react";
import AlertaBrecha from "../AlertaBrecha";
import cesta from "../assets/basket.svg";
import dieta from "../assets/fruit.svg";
import suscripcion from "../assets/subscription.svg";
import furgoneta from "../assets/van.svg";
import Header from "../Header";
import "./styles.css";

function Inicio() {
  const [estadoBrecha, setEstadoBrecha] = useState([]);

  const fetchDevuelveBrecha = useCallback(() => {
    return fetch("/brecha/devuelveBrecha", {
      method: "GET",
    })
      .then((response) => response.json())
      .then((estadoBrecha) => {
        setEstadoBrecha(estadoBrecha);
      });
  }, []);

  useEffect(() => {
    fetchDevuelveBrecha(estadoBrecha);
  }, []);

  return (
    <div>
      <Header />
      {estadoBrecha == true ? (
        <p>
          <AlertaBrecha />
        </p>
      ) : (
        <div className="homepage">
          <p className="homepage-welcome">Bienvenidos a You Market</p>
          <div className="homepage-services container">
            <div className="homepage-service service-left">
              <img
                className="service-image"
                src={suscripcion}
                alt="Suscripción mensual"
              />
              <div className="service-information">
                <p className="service-title">Suscripción mensual</p>
                <p className="service-text">
                  Tenemos diferentes tarifas dependiendo de tus necesidades.
                  ¡Elige la que mejor se ajuste a ti!
                </p>
              </div>
            </div>
            <div className="homepage-service service-middle">
              <img
                className="service-image"
                src={cesta}
                alt="Cestas personalizadas"
              />
              <div className="service-information">
                <p className="service-title">Cestas personalizadas</p>
                <p className="service-text">
                  ¿Repites una compra varias veces? Puedes guardar tu carrito
                  como cesta para utilizarla en futuras ocasiones. ¡Ahorras
                  tiempo!
                </p>
              </div>
            </div>
            <div className="homepage-service service-middle">
              <img
                className="service-image"
                src={dieta}
                alt="Dietas y recetas"
              />
              <div className="service-information">
                <p className="service-title">Dietas y recetas</p>
                <p className="service-text">
                  Tendrás acceso a un catálogo de dietas con recetas
                  relacionadas elegidas por nuestros nutricionistas.
                </p>
              </div>
            </div>
            <div className="homepage-service service-right">
              <img
                className="service-image"
                src={furgoneta}
                alt="Somos Ecofriendly"
              />
              <div className="service-information">
                <p className="service-title">¡Somos Ecofriendly!</p>
                <p className="service-text">
                  En You Market somos respetuosos con el medio ambiente, por lo
                  que todos nuestros repartos se realizan con vehículos
                  eléctricos.
                </p>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default Inicio;
