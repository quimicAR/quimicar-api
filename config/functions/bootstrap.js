"use strict";

/**
 * An asynchronous bootstrap function that runs before
 * your application gets started.
 *
 * This gives you an opportunity to set up your data model,
 * run jobs, or perform some special logic.
 *
 * See more details here: https://strapi.io/documentation/developer-docs/latest/setup-deployment-guides/configurations.html#bootstrap
 */

module.exports = () => {
  const data = require("../../data/elements.json");
  data.elements.forEach((element) => {
    strapi.services.elements.create({
      id: element.number,
      name: element.name,
      number: element.number,
      atomic_mass: element.atomic_mass,
      appearance: element.appearance,
      boil: element.boil,
      category: element.category,
      density: element.density,
      discovered_by: element.discovered_by,
      melt: element.melt,
      molar_heat: element.molar_heat,
      named_by: element.named_by,
      period: element.period,
      phase: element.phase,
      source: element.source,
      spectral_img: element.spectral_img,
      summary: element.summary,
      symbol: element.symbol,
      xpos: element.xpos,
      ypos: element.ypos,
      shells: JSON.stringify(element.shells),
      electron_configuration: element.electron_configuration,
      electron_configuration_semantic: element.electron_configuration_semantic,
      electron_affinity: element.electron_affinity,
      electronegativity_pauling: element.electronegativity_pauling,
      ionization_energies: JSON.stringify(element.ionization_energies),
    });
  });
};
