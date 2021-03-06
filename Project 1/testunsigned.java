#> InputSetLoader: gvFormat.InputSetLoaderSimpleGVFormat

#################################################################
#
# *Partially* test a 16-bit signed adder.  (The student is
# responsible for designing a more comprehensive test.)
# To add tests, simply add more values to the named lists below
# (lowPositive, lowNegative, allPositive, and allNegative).
#
# Author: Zachary Kurmas
# (C) 2014 Grand Valley State University
#
#################################################################

OUTPUT_SET_TYPE SHARED UnsignedAdderOutputSet

NAMED_VALUE_LISTS
  # The sum of any two lowPositive or lowNegative values will not overflow
  lowPositive  [ 0, 1, 2^15 - 1, 10, 3089, 25091, 2^15 + 36, 12, 102 ]
  allPositive  [ lowPositive,  2^16 - 2, 2^16 - 1, 2^16 - 12 ]

###########################
#
# no overflow
#
###########################

BEGIN noOverflow
  INPUTS
    InputA lowPositive
    InputB lowPositive
    CarryIn [ 0, 1 ]
  OUTPUTS
    # Tell JLSCircuitTester to ignore value of Overflow output pin
    CarryOut EXCLUDE


#########################
#
# Overflow
#
#########################

BEGIN positive_overflow
  INPUTS
    InputA allPositive
    InputB allPositive
    CarryIn [0, 1]
 OUTPUTS   
    CarryOut REQUIRE
