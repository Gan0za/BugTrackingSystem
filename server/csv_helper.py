import pandas as pd

def save_file(list_on_text, name_file):
    print (list_on_text)
    df = pd.DataFrame(list_on_text)
    df.to_csv("./server/temp_files/" + name_file + '.csv', index=False, header=False)  


    