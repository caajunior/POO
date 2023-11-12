/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poo;

import javax.swing.JOptionPane;

class Planet {
    private String name;
    private boolean rocky;
    private boolean hasRings;
    private boolean hasAtmosphere;
    private boolean isTerrestrial;
    private boolean hasWater; // Modified characteristic
    private boolean hasLife; // Modified characteristic

    public Planet(String name, boolean rocky, boolean hasRings, boolean hasAtmosphere, boolean isTerrestrial, boolean hasWater, boolean hasLife) {
        this.name = name;
        this.rocky = rocky;
        this.hasRings = hasRings;
        this.hasAtmosphere = hasAtmosphere;
        this.isTerrestrial = isTerrestrial;
        this.hasWater = hasWater;
        this.hasLife = hasLife;
    }

    public String getName() {
        return name;
    }

    public boolean isRocky() {
        return rocky;
    }

    public boolean hasRings() {
        return hasRings;
    }

    public boolean hasAtmosphere() {
        return hasAtmosphere;
    }

    public boolean isTerrestrial() {
        return isTerrestrial;
    }

    public boolean hasWater() {
        return hasWater;
    }

    public boolean hasLife() {
        return hasLife;
    }
}

class GuessingGame {
    private boolean parseYesNoResponse(int response) {
        return response == JOptionPane.YES_OPTION;
    }

    private Planet askQuestion(Planet[] planets) {
        int answerRocky = JOptionPane.showConfirmDialog(null, "Is your planet rocky?", "Question", JOptionPane.YES_NO_OPTION);
        int answerRings = JOptionPane.showConfirmDialog(null, "Does your planet have rings?", "Question", JOptionPane.YES_NO_OPTION);
        int answerAtmosphere = JOptionPane.showConfirmDialog(null, "Does your planet have an atmosphere?", "Question", JOptionPane.YES_NO_OPTION);
        int answerTerrestrial = JOptionPane.showConfirmDialog(null, "Is your planet terrestrial?", "Question", JOptionPane.YES_NO_OPTION);
        int answerHasWater = JOptionPane.showConfirmDialog(null, "Does your planet have water?", "Question", JOptionPane.YES_NO_OPTION);
        int answerHasLife = JOptionPane.showConfirmDialog(null, "Does your planet have life?", "Question", JOptionPane.YES_NO_OPTION);

        for (Planet planet : planets) {
            if (parseYesNoResponse(answerRocky) == planet.isRocky() &&
                    parseYesNoResponse(answerRings) == planet.hasRings() &&
                    parseYesNoResponse(answerAtmosphere) == planet.hasAtmosphere() &&
                    parseYesNoResponse(answerTerrestrial) == planet.isTerrestrial() &&
                    parseYesNoResponse(answerHasWater) == planet.hasWater() &&
                    parseYesNoResponse(answerHasLife) == planet.hasLife()) {
                return planet;
            }
        }

        return null; // No matching planet found
    }

    private void showAdditionalInfo(Planet planet) {
        JOptionPane.showMessageDialog(null,
                "Additional information about " + planet.getName() + ":\n" +
                        "Has Water: " + planet.hasWater() + "\n" +
                        "Has Life: " + planet.hasLife());
    }

    public void startGame() {
        JOptionPane.showMessageDialog(null, "Welcome to the Planet Guessing Game!");
        JOptionPane.showMessageDialog(null, "I will try to guess the planet you are thinking of...");

        // Create an array of planets
        Planet[] planets = {
                new Planet("Saturn", false, true, true, false, false, false),
                new Planet("Mars", true, false, true, true, false, false),
                new Planet("Mercury", true, false, false, false, false, false),
                new Planet("Uranus", false, true, true, false, false, false),
                new Planet("Jupiter", false, false, true, false, false, false),
                new Planet("Earth", true, false, true, true, true, true),
                new Planet("Venus", true, false, true, true, false, false),
                new Planet("Neptune", false, true, true, false, false, false)
        };

        // Start the guessing process
        Planet guessedPlanet = askQuestion(planets);

        if (guessedPlanet != null) {
            JOptionPane.showMessageDialog(null, "Great! I guessed it. Your planet is " + guessedPlanet.getName() + "!");
            showAdditionalInfo(guessedPlanet);
        } else {
            JOptionPane.showMessageDialog(null, "I couldn't guess your planet. Maybe I need more information!");
        }
    }
}

public class POO {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.startGame();
    }
}
