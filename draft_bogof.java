public double createBogofArray(ArrayList<Buyable> items){
  Double bogofDiscount = 0;
  
  bogofItems = new ArrayList<Buyable>(items);
  
  for (int i=0; i<bogofItems.size(); i++){
    if (bogofItems.get(i).checkBogof == false){
      bogofItems.delete(i);
    }
  }

  bogofItems.sort(Comparator.comparing(Buyable::getPrice()));

}

public double calcBogofDiscount(ArrayList<Buyable> bogofItems){
  while(bogofItems.size() > 1){
    bogofItems.get(0) = greater;
    bogofItems.delete(0);
    for(int i=bogofItems.size()-1; i=0; i--){
      if(bogofItems.get(i).getClass() == greater.getClass()){
        bogofDiscount += bogofItems.get(i).getPrice();
        bogofItems.delete(i);
      }
    }
  }

}
