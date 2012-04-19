(ns overtone.device.protocols)

#_(defprotocol GridInput
  "A generic representation of a grid of buttons."
  (on-action [this f]
    "Registers a callback fn, to be called whenever one of the buttons
     is pressed or released. If a handler has already been registered
     replace the old handler with this new one.

     The handler fn should take three args: [action x y], where action
     is a keyword from the set #{:pressed :released} and x and y are
     the coords of the button being pressed."))

(defprotocol Dimensions
  "A rectangular grid of elements."
  (width [this]
    "Returns the number of elements of the grid width-wise. This value
    is not expected to change.")
  (height [this]
    "Returns the number of elements of the grid height-wise. This
    value is not expected to change."))

(defprotocol GridDisplay
  "A generic representation of a grid of lights. Entities which extend
   GridDisplay should also extend Dimensions."
  (light-on [this x y]
    "Illuminates the light at position [x y].")
  (light-on-all [this]
    "Illuminates all lights")
  (light-off [this x y]
    "Extinguishes the light at position [x y].")
  (light-off-all [this]
    "Extinguishes all lights")
  (light-frame [this leds]
    "Update the entire field of lights. The rows arg is a map of coords
    to truthy or falsey values.

    For example, if you have a 2x2 grid, you could update all of the
    lights like this:

    (light-frame grid {[0 0] true  [1 0] false
                       [0 1] false [1 1] true})"))

(defprotocol ColourGridDisplay
  "A generic representation of a grid of lights which can be
   illuminated in multiple different colours. Entities which extend
   ColourGridDisplay should also extend Dimensions."
  (light-colour [this x y colour]
    "Set the light at position [x y] to the given colour. Color 0 is
    off, > 0 represents a specific palette colour. Subject to
    change.")
  (light-colour-all [this colour]
    "Sets all light to a single colour or off if 0.")
  (light-colour-frame [this leds]
    "Update the entire field of lights. The rows arg is a map of coords
    to colour values, the same as in led-set. Any unspecified coords
    should default to 0.

    For example, if you have a 2x2 grid, you could update all of the
    lights like this:

    (light-frame grid {[0 0] 1 [1 0] 0
                       [0 1] 0 [1 1] 1})"))

#_(defprotocol Button
  (on-action [this f]
    "Registers a callback fn, to be called when the button is pressed
    or released. If a handler has already been registered, replace the
    old handler with this new one.

   The handler fn should take one arg [action], where action is a
   keyword from the set #{:pressed :released}"))

#_(defprotocol Light
  (light-set [this colour]
    "Set the light to the given colour. Color 0 is off, > 0 represents a
    specific palette colour. Subject to change."))

#_(defprotocol RangedInput
  (min-val [this]
    "Returns the minimum value the slider will output. This value is
    not expected to change.")
  (max-val [this]
    "Returns the maximum value the slider will output. This value is
    not expected to change.")
  (on-action [this f]
    "Registers a callback fn, to be called when the slider is
    moved. If a handler has already been registered, replace the old
    handler with this new one."))
