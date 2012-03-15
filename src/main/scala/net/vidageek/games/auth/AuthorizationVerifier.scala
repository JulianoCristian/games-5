package net.vidageek.games.auth
import org.scribe.model.Verifier

object AuthorizationVerifier {
  def apply(oAuthVerifier: String): AuthorizationVerifier  = oAuthVerifier match {
    case null => new UnatorizedResponse()
    case _ => new VerifiedResponse(new Verifier(oAuthVerifier))
  }
}

trait AuthorizationVerifier {
  def authorized: Boolean
  
  def verifier: Verifier
}

class VerifiedResponse(verifierResponse: Verifier) extends AuthorizationVerifier{
  
  override def authorized = true
  
  def verifier: Verifier = verifierResponse
  
}

class UnatorizedResponse() extends AuthorizationVerifier {
  override def authorized = false
  
  def verifier: Verifier = new Verifier("InvalidVerifier")
}