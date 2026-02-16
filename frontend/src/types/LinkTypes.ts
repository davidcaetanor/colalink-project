
export interface LinkResponse{
  urlOriginal: string; 
  urlShortened: string;
  dataExpiration: string;
}

export interface LinkRequest{
    urlOriginal: string;
}