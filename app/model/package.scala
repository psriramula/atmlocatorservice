package model

case class GeoLocation(lat:String,lng:String)
case class Address(street:String, housenumber:String, postalcode:String, city:String, geoLocation: GeoLocation)
case class ATMLocation( address: Address, distance:Double, `type`:String)