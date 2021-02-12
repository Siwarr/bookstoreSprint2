package tn.esprit.demo.service;

import com.stripe.exception.StripeException;
import com.stripe.model.Customer;

public interface IPayementService {
    public Customer getCurrentCustomer(String m)throws StripeException;
    public void AjoutCard(Customer a,String m,String l,String k,String j)throws StripeException;
    public void AjoutCustomer(String k)throws StripeException;
    public void Payement(Customer a,String s)throws StripeException;
}
